import { createStore } from 'vuex'
import axios from 'axios'

export default createStore({
  state: {
    categories: [],
    channels: [],
    searchQuery: "P",
    programs: [],
    programById: {},
    programId: 0,
    categoryId: 0, 
    programsByCategoryId: [],
    loggedInUser: null,
    channelId:0,
    programsByChannelId:[],
    tempCategoryName: String,
    tempChannelName: String,
    programsByChannelIdAndDate:[],
    tempChannelId:164,
    theDate:"2021-04-13",
    episodesByProgramId: []
  },


  // Metoder som används för att manipulera datan.
  // Påkallas med commit
  mutations: {
    setCategory(state, payload){
      state.categories = payload;
    },

    setChannel(state, payload){
      state.channels = payload;
    },
    setPrograms(state, payload) {
      state.programs = payload;
    },
    setSearchQuery(state, payload) {
      state.searchQuery = payload;
    },
    setProgramById(state, payload) {
      state.programById = payload;
    },
    setProgramId(state, payload) {
      state.programId = payload;
    },
    setLoggedInUser(state, user) {
      state.loggedInUser = user
    },
    setCategoryId(state, payload) {
      state.categoryId = payload;
    },
    setProgramsByCategoryId(state, payload) {
      state.programsByCategoryId = payload;
    },
    setChannelId(state, payload) {
      state.channelId = payload;
    },
    setProgramsByChannelId(state, payload) {
      state.programsByChannelId = payload;
    },
    setTempCategoryName(state, payload){
      state.tempCategoryName=payload;
    },
    setTempChannelName(state, payload){
      state.tempChannelName=payload;
    },
    setTempChannel(state, payload){
      state.tempChannelId=payload;
    },
    setTheDate(state, payload){
      state.theDate=payload;
    },

    setBroadcastOnChannel(state, payload) {
      state.programsByChannelIdAndDate = payload;
    
    },
    setEpisodesOnProgram(state, payload) {
      state.episodesByProgramId = payload;
    }

  },



  //Kommunikationen med backend(API), hämtar data och tillsätter i state.
  actions: {
    async fetchCategory(){
      await axios.get("http://localhost:3001/rest/categories")
      .then(response => {
       this.commit("setCategory", response.data) 
       console.log(response.data)
      })
    },

    async fetchChannel(){
      await axios.get("http://localhost:3001/rest/channelscleaned")
      .then(response => {
       this.commit("setChannel", response.data) 
       console.log(response.data)
      })
    },
    async fetchPrograms() {
      console.log('SearchQuery is: '+this.state.searchQuery)
      const url ='http://localhost:3001/rest/programs/' + this.state.searchQuery
      await axios.get(url)
      .then(response => {
       this.commit("setPrograms", response.data) 
      })
    },
    async fetchProgramById() {
      console.log('FetchProgramById running')
      const url ='http://localhost:3001/rest/programs/id/' + this.state.programId
      await axios.get(url)
      .then(response => {
       this.commit("setProgramById", response.data) 
      })
    },
    async fetchProgramsByChannelId() {
      console.log('Channel id is: '+this.state.channelId)
      const url ='http://localhost:3001/rest/programs/channel/' + this.state.channelId
      await axios.get(url)
      .then(response => {
       this.commit("setProgramsByChannelId", response.data) 
      })
    },
    async fetchProgramsByCategoryId() {
      console.log('Category Id: '+ this.state.categoryId)
      const url = 'http://localhost:3001/rest/programs/category/' + this.state.categoryId
      await axios.get(url)
      .then(response => {
        this.commit("setProgramsByCategoryId", response.data)
      })
    },

    async fetchEpisodesOnChannelAndDate() {
      
      const url = 'http://localhost:3001/rest/episodes/' +this.state.tempChannelId+"/"+ this.state.theDate
      console.log(url)
       await axios.get(url)
      .then(response => {
        this.commit("setBroadcastOnChannel", response.data)
      })
    },
  async fetchEpisodesOnProgram() {
    console.log('Get the episodes by programId' + this.state.programId)
    const url ='http://localhost:3001/rest/episodes/' + this.state.programId
    await axios.get(url)
    .then(response => {
      this.commit("setEpisodesOnProgram", response.data) 
    })

  },
},




  // Hämtar datan åt komponenter
  getters: {
    getCategory(state){
      return state.categories
    },

    getChannel(state){
      return state.channels
    },
    getPrograms(state){
      return state.programs
    },
    getProgramById(state){
      return state.programById
    },
    getProgramsByCategoryId(state) {
      return state.programsByCategoryId
    },
    getProgramsByChannelId(state){
      return state.programsByChannelId
    },
    getCategoryName(state){
      return state.tempCategoryName
    },
    
    getChannelName(state){
      return state.tempChannelName
    },
    getChannelId(state){
      return state.tempChannelId
    },

    getBroadcastOnChannel(state){
      return state.programsByChannelIdAndDate
    },
  
    getEpisodesOnProgram(state) {
      return state.episodesByProgramId
    },
  }
  
})

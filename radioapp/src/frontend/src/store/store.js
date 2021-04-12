import { createStore } from 'vuex'
import axios from 'axios'

export default createStore({
  state: {
    categories: [],
    channels: [],
    searchQuery: "",
    programs: [],
    programById: {},
    programId: 0,
    categoryId: 0, 
    programsByCategoryId: []
    loggedInUser: null
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
      const url ='http://localhost:3001/rest/programs/' + this.state.name
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
  async fetchProgramsOnChannel() {
    console.log('SearchQuery is: '+this.state.searchQuery)
    const url ='http://localhost:3001/rest/programs/channel/{id}' + this.state.searchQuery
    await axios.get(url)
    .then(response => {
     this.commit("setPrograms", response.data) 
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
  },
  
})

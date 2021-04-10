import { createStore } from 'vuex'
import axios from 'axios'

export default createStore({
  state: {
    categories: [],
    channels: [],
    searchQuery: "P",
    programs: [],
    channelId:0
  },


  // Metoder som används för att komma åt/manipulera datan.
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
    setChannelId(state, payload) {
      state.channelId = payload;
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
    async fetchProgramsOnChannel() {
      console.log('SearchQuery is: '+this.state.channelId)
      const url ='http://localhost:3001/rest/channelscleaned/' + this.state.channelId
      await axios.get(url)
      .then(response => {
       this.commit("setChannelId", response.data) 
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
  },
  
})

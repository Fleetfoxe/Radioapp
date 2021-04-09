import { createStore } from 'vuex'
import axios from 'axios'

export default createStore({
  state: {
    categories: [],
    channels: []
  },


  // Metoder som används för att komma åt/manipulera datan.
  // Påkallas med commit
  mutations: {
    setCategory(state, payload){
      state.categories = payload;
    },

    setChannel(state, payload){
      state.channels = payload;
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
    }
  },

  // Hämtar datan åt komponenter
  getters: {
    getCategory(state){
      return state.categories
    },

    getChannel(state){
      return state.channels
    }
  },





  modules: {
  }
})

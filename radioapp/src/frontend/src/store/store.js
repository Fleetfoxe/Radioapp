import { createStore } from 'vuex'
import axios from 'axios'

export default createStore({
  state: {
    categories: []
  },


  // Metoder som används för att komma åt/manipulera datan.
  // Påkallas med commit
  mutations: {
    setCategory(state, payload){
      state.categories = payload;
    }
  },


  // Kommunikationen med backend(API), hämtar data och tillsätter i state.
  actions: {
    async fetchCategory(){
      await axios.get("/rest/categories")
      .then(response => {
       this.commit("setCategory", response.data) 
       console.log(response.data)
      })
    }
  },

  // Hämtar datan åt komponenter
  getters: {
    getCategory(state){
      return state.categories
    }
  },





  modules: {
  }
})

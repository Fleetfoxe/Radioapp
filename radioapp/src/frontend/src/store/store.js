import { createStore } from 'vuex'
import axios from 'axios'

export default createStore({
  state: {
    category: String
  },


  // Metoder som används för att komma åt/manipulera datan.
  // Påkallas med commit
  mutations: {
    setCategory(state, payload){
      state.category = payload;
    }
  },


  //Kommunikationen med backend(API), hämtar data och tillsätter i state.
  actions: {
    async fetchCategory(){
      await axios.get("http://localhost:3000/rest/categories")
      .then(response => {
       this.commit("setCategory", response.data) 
      })
    }
  },

  // Hämtar datan åt komponenter
  getters: {
    getCategory(state){
      return state.category
    }
  },





  modules: {
  }
})

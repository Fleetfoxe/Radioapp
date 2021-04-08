import { createStore } from 'vuex'
import axios from 'axios'

export default createStore({
  state: {
    searchQuery: "Arkivet",
    category: [],
    programs: [],
    },


  // Metoder som används för att komma åt/manipulera datan.
  // Påkallas med commit
  mutations: {
    setCategory(state, payload){
      state.category = payload;
    },
    setProgram(state, payload) {
      state.programs = payload;
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
    async fetchPrograms() {
      //searchQuery = this.getSearchQuery()
      let url ="http://localhost:3001/rest/programs"
      await axios.get(url)
      .then(response => {
       this.commit("setProgram", response.data) 
       console.log(response.data)
      })
    }
  },

  // Hämtar datan åt komponenter
  getters: {
    getCategory(state){
      return state.category
    },
    getPrograms(state){
      return state.programs
    },
    getSearchQuery(state) {
      return state.searchQuery
    }
  },





  modules: {
  }
})

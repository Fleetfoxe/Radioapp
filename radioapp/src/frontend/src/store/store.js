import { createStore } from 'vuex'
import axios from 'axios'

export default createStore({
  state: {
    hello: String
  },
  mutations: {
    setHello(state, payload) {
      state.hello = payload;
    }
  },
  actions: {
    async fetchHello() {
      await axios.get("http://localhost:8080/api/test/hello")
      .then(response => {
        this.commit("setHello", response.data)
      })
    }
  },


  getters: {
    getHello(state) {
      return state.hello
    }
  },




  modules: {
  }
})

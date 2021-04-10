<template>
  <div id="nav">
    <Navbar />
  </div>
  <router-view/>
</template>

<script>
import Navbar from "./components/Navbar"
export default {
  components:{
    Navbar
  },
  async mounted() {
        let user = await fetch('/auth/whoami')
        try {
          user = await user.json()
          this.$store.commit('setLoggedInUser', user)
          console.log(user)
        } catch {
          console.log('Not logged in')
        }
  }
  
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>

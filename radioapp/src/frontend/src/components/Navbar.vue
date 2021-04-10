<template>
  <nav>
      <router-link to="/">Home</router-link>
      -
      <router-link to="/channellist">ChannelList</router-link>
      -
      <router-link to="/categorylist">CategoryList</router-link>
      -
      <router-link to="/programlist">ProgramList</router-link>
      -
      <router-link to="/Login">Login</router-link>
      /
      <button @click="logout">Logout</button>

  </nav>
</template>

<script>
export default {
  methods: {
    logout() {
            //logout from backend
            fetch('/logout', {mode: 'no-cors'})
            
            //removes user from store.js
            this.$store.commit('setLoggedInUser', null)
            }
          }
}
</script>

<style scoped>
nav {
  padding: 5px;
  background-color: lightblue;
  border-bottom: 2px solid lightgray;
  color: white;
}
a {
  color: white
}

a:hover {
  color: black;
}

</style>
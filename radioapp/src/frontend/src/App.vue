<template>
 
   <div id="ourTitle">Our RadioApp</div>
   <div id="nav">
    <Navbar />
    </div>
     
<!--<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/dark.css">-->
 
 <!-- <link rel="stylesheet" href="/styles.css"> -->
  
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
          console.log(user.email +" is logged in")
        } catch {
          console.log('Not logged in')
        }
  }
  
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  font-style: italic;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-color: cadetblue;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #cae6d9;
}
#ourTitle{
   font-family: Avenir, Helvetica, Arial, sans-serif;
   font-size: 90px;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;

}




</style>

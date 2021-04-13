<template>
 
   <div id="ourTitle">Our RadioApp</div>
   <div id="nav">
    <Navbar />
    </div>
     
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/dark.css">
 
  <link rel="stylesheet" href="/styles.css"> 
  
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





</style>

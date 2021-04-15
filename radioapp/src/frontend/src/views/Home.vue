<template>
  <div class="home">
    <h1 v-if ="!isLoggedIn">Welcome!</h1>
    <h1 v-if="isLoggedIn">Welcome {{ loggedInUser.email }}!</h1>
  </div>
</template>

<script>
export default {
  name: 'Home',
  components: {
  },

  computed: {
    loggedInUser() {
      return this.$store.state.loggedInUser
    },
    isLoggedIn() {
      return this.loggedInUser != null
    }
  }
}
</script>
<style>
#Home{
  height: 100%;
  background-color: cadetblue;}
</style>

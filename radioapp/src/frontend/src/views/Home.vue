<template>
  <div class="home">
    <h1>Welcome</h1>
    <h1 v-if="isLoggedIn">{{ loggedInUser.name }}!</h1>
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

</style>

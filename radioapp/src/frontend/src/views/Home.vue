<template>
  <div class="home">
    <h1>Welcome!</h1>
    <h1> {{ getHello }} </h1>
  </div>
</template>

<script>

export default {
  name: 'Home',
  
  computed: {
    getHello() {
      return this.$store.getters.getHello
    }
  },

  mounted() {
    this.$store.dispatch("fetchHello");
  }
}
</script>

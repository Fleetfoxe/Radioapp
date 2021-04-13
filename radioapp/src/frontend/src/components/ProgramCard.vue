<template>
<div class="program-card" @click="redirectToProgramDetails">
<span>
  <h2>
    {{program.name}}
  </h2>
  <button @click="">Add favorite</button>
  </span>
</div>
</template>

<script>
export default {
  props: ["program"],

  methods: {
    redirectToProgramDetails() {
      let routerUrl = '/program-details/' + this.program.id
      this.$router.push({path: routerUrl})
    }
  }
    
}
</script>

<style>
.program-card {
  background-color: lightgray;
  margin-bottom: 20px;
  padding: 10px;
  font-family: 'Arial';
  border-radius: 30px;
  border: 5px solid whitesmoke;
}

</style>
<template>
<div class="program-card" @click="redirectToProgramDetails">
<span>
  <h2>
    {{program.name}}
  </h2>
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

</style>
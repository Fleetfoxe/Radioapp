<template>
  <div>
      <h1>program details</h1>
      <h4>id: {{ id }}</h4>
  </div>
</template>

<script>
export default {
    data() {
        return {
            id:''
        }
    },

    mounted() {
        console.log(this.$route.params.id)

        this.id = this.$route.params.id
    }

}
</script>

<style>

</style>
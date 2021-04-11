<template>
  <div>
      <h1>Programs by category</h1>
      
</div>

        <div v-if="programsByCategoryId.length > 0">
      <ProgramCard
        v-for="(program, i) in programsByCategoryId"
        :key="program + i"
        :program="program"
      />
  </div>
</template>

<script>
import ProgramCard from "../components/ProgramCard.vue";


export default {
   data() {
       return {
            id:''
        }
      
    },
      mounted() {
        this.id = this.$route.params.id
        this.$store.commit("setCategoryId", this.id)
        this.$store.dispatch("fetchProgramsByCategoryId"); // Something makes this shit unknown
    },


    components: {
    ProgramCard
  },

  computed: {
    programsByCategoryId() {
            return this.$store.getters.getProgramsByCategoryId
        },
    
  },


}
</script>

<style>

</style>
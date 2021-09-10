<template>
  <div>
      <h1>Category: {{categoryName}}</h1>
       
      <h2>programs:</h2>

      
</div>
      <!-- Insert program in programsByCategoryId (Nestlar componenten ProgramCard i CategoryDetails)  (User story 5)-->
      <!-- Loopar ut (v-for) listan av program enskilt = Skapar varje "program" som en egen komponent (User story 5)-->
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
        this.$store.dispatch("fetchProgramsByCategoryId");
    },


    components: {
    ProgramCard
  },

  computed: {
    programsByCategoryId() {
            return this.$store.getters.getProgramsByCategoryId
        },

        categoryName(){
          return this.$store.getters.getCategoryName
        }
    
  },


}
</script>

<style>

</style>
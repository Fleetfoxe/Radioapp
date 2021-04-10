<template>
  <div>
      <h1>Programs by category</h1>
      
</div>

        <div v-if="programs.length > 0">
      <ProgramCard
        v-for="(program, i) in programs"
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
        console.log(this.$route.params.id)

        this.id = this.$route.params.id
    },

    methods: {
        searchMethod() {
             let id = this.id
    
            this.$store.commit("setSearchQuery", id)
            this.$store.dispatch("fetchProgramsOnCategory");
        }
    },

    components: {
    ProgramCard
  },

  computed: {
    programs() {
            return this.$store.getters.getPrograms
        },
    
  },
 // mounted() {
 //       this.$store.dispatch("fetchProgramsOnChannel");
   // }


}
</script>

<style>

</style>
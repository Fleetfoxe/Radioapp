<template>

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
  components: {
    ProgramCard,
  },

  computed: {
    programs() {
            console.log(this.programs);
            return this.$store.getters.getPrograms
        },
    
  },
  mounted() {
        this.$store.dispatch("fetchPrograms");
    }
};
</script>

<style>

</style>
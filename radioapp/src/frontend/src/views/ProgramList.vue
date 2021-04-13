<template>
<div>
<form @submit.prevent="searchMethod">
<input type="text" id="search" placeholder="type search" v-model="searchtext">
<button type="submit">Search</button>
</form>
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
            searchtext: ""
        }
    },

    methods: {
        searchMethod() {
            let searchtext = this.searchtext
            console.log("searchtext is: "+searchtext);
            this.$store.commit("setSearchQuery", searchtext)
            this.$store.dispatch("fetchPrograms");
        }
    },
  components: {
    ProgramCard,
  },

  computed: {
    programs() {
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
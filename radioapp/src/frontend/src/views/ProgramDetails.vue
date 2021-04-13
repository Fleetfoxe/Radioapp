<template>
  <div>
      <h1>{{ program.name }}</h1>
      <h4>{{ program.description }}</h4>
      <h4>Link to program image: </h4>
      <p>{{ program.programimage }}</p>
      <p>{{ program.id }}</p>
  </div>    
     <div v-if="episodesByProgramId.length > 0">
      <EpisodeCard
        v-for="(episode, i) in episodesByProgramId"
        console.log(episodesByProgramId)
        :key="episode + i"
        :episode="episode"
      />
  </div>

    <h1>{{ episodesByProgramId }}</h1>
    
</template>

<script>
import EpisodeCard from "../components/EpisodeCard";
export default {
    data() {
        return {
            //Here is the id of the program stored in this view
            id:''
        }
        
    },
    computed: {
    program() {
            //This is step 4. Here we get the program object from store that comes from springboot 
            return this.$store.getters.getProgramById
        },
         episodesByProgramId() {
            return this.$store.getters.getEpisodesOnProgram
       },
    },

    mounted() {
        //This is step 1. Here we take the id form this pages url and puts it id int in data()
        this.id = this.$route.params.id

        //This is step 2. We take the id from the id int in data() and we send it to ProgramId int in store.js
        // it will be used to fetch the correct program from springboot
        this.$store.commit("setProgramId", this.id)

         
         this.$store.dispatch("fetchEpisodesOnProgram");

         
        //This is step 3. Here we activate the connection to springboot with action fetchProgramById
        this.$store.dispatch("fetchProgramById");

         this.$store.commit("setEpisodeByProgramIdFromSR");

    },
    components: {
        EpisodeCard
    }

}
</script>

<style>

</style>
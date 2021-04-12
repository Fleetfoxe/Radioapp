<template>
  <div>
      <h1>channel details</h1>
    

      
</div>

        <div v-if=" programsByChannelId.length > 0">
      <ProgramCard
        v-for="(program, i) in  programsByChannelId"
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
    
      //This is step 2. We take the id from the id int in data() and we send it to ChannelId int in store.js
        // it will be used to fetch the correct program from springboot
        this.$store.commit("setChannelId", this.id)
      

        //This is step 3. Here we activate the connection to springboot with action fetchProgramsByChannelId
        this.$store.dispatch("fetchProgramsByChannelId");},

    

    components: {
    ProgramCard
  },

  computed: {
    programsByChannelId() {
            return this.$store.getters.getProgramsByChannelId
        },
    
  },
 // mounted() {
 //       this.$store.dispatch("fetchProgramsOnChannel");
   // }


}
</script>

<style>

</style>
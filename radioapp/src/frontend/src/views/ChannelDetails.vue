<template>
  <div>
      <h1>Programs on {{channelName}}</h1>
      <h2>channel details</h2>

      <form @submit.prevent="searchMethod">
      <input type="text" id="search" placeholder="type search" v-model="searchDate">
      <button type="submit">Date</button>
      </form>
     
  </div>

        <div v-if=" programsByChannelId.length > 0">
      <ProgramCard
        v-for="(program, i) in  programsByChannelId"
        :key="program + i"
        :program="program"
      />
      </div>

        <div v-if=" broadcastOnChannel.length > 0">
      <EpisodeCard
        v-for="(episode, i) in  broadcastOnChannel"
        :key="episode + i"
        :episode="episode"
      />
      
      </div> 
<!--
<h1>
{{broadcastOnChannel}}
</h1>
-->

</template>

<script>
import ProgramCard from "../components/ProgramCard.vue";
import EpisodeCard from "../components/EpisodeCard.vue";


export default {
   data() {
       return {
            id:'',
            searchDate:''
           
        }
      
    },
    
    

     methods: {
        searchMethod() {
            let searchDate = this.searchDate
            console.log("search date is: "+searchDate);
            this.$store.commit("setTheDate", searchDate)
            this.$store.dispatch("fetchEpisodesOnChannelAndDate");
        }
    },

    components: {
    ProgramCard,
    EpisodeCard
  },

  computed: {
    programsByChannelId() {
            return this.$store.getters.getProgramsByChannelId
        },
     broadcastOnChannel() {
           return this.$store.getters.getBroadcastOnChannel
           
        },
        
      channelName(){
          return this.$store.getters.getChannelName
        },

        //för att få id på kanalen att använda i sök
      channelId(){
          return this.$store.getters.getChannelId
        }

    
  },

    mounted() {
       
        this.id = this.$route.params.id
    
      //This is step 2. We take the id from the id int in data() and we send it to ChannelId int in store.js
        // it will be used to fetch the correct program from springboot
        this.$store.commit("setChannelId", this.id)
             

        //This is step 3. Here we activate the connection to springboot with action fetchProgramsByChannelId
        this.$store.dispatch("fetchProgramsByChannelId");
         this.$store.dispatch("fetchEpisodesOnChannelAndDate");
      },
 


}
</script>

<style>


</style>
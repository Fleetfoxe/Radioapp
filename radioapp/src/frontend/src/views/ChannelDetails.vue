<template>
  <div>
      <h1>Broadcast and Programs on {{channelName}}</h1>
      <h2>----------------------------------------</h2>
</div>
<div class="split left">
  <div class="centerd">
      <h2>search episodes on date</h2>

      <form @submit.prevent="searchMethod">
      <input type="text" id="search" placeholder="YYYY-MM-DD" v-model="searchDate">
      <button type="submit">Date</button>
      </form>
  
     <h1>Episodes</h1>

        <li  class="episodes" v-if=" broadcastOnChannel.length > 0">
      <EpisodeCard
        v-for="(episode, i) in  broadcastOnChannel"
        :key="episode + i"
        :episode="episode"
      />
      
      </li> 
      </div>
      </div>

      <div class="split right">
         <div class="centerd">
      <h1>Programs</h1>
          <li class="programs" v-if=" programsByChannelId.length > 0">
      <ProgramCard
        v-for="(program, i) in  programsByChannelId"
        :key="program + i"
        :program="program"
      />
      </li>     
      </div>
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
    ProgramCard, EpisodeCard
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
.split{
  height: 100%;
  width: 50%;
  position:fixed;
  z-index:1;
  top:auto;
  overflow-x: hidden;
  padding-top: 20px;
  

}
.left{
  left:0;
  background-color: #2c3e50;
}
.right{
  right:0;
  background-color:#2c3e50;
}
.centered{
  position:absolute;
  top:50%;
  left: 50%;
  transform: translate(-50%,-50%);
  text-align: center;
}


</style>
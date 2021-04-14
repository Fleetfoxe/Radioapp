<template>
 
 <div class="top">
      {{ program.name }}</div>
      <div class="top2">
      {{ program.description }}
      </div>
 <div class="split left">
  <div class="centered">
      <img v-bind:src="program.programimage">
   
    </div> 
    </div >
      <!--<p>{{ program.id }}</p> -->

 <div class="split right">
  <div class="centered">
      
     <li class="episode-list" v-if="episodesByProgramId.length > 0">
         
      <EpisodeCard
        v-for="(episode, i) in episodesByProgramId"
        :key="episode + i"
        :episode="episode"
      />
  </li>
  </div>
  </div>

    
</template>

<script>
import EpisodeCard from "../components/EpisodeCard";
export default {
    data() {
        return {
            //Here is the id of the program stored in this view
            id:'',
            
            
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

       //  this.$store.commit("setEpisodeByProgramIdFromSR");

    },
    date() {
        
    },
    components: {
        EpisodeCard,
    }

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
  padding-top: 10px;
  

}
.left{
  left:0;
  background-color: #2c3e50;
 
}
.right{
  right:0;
  background-color: #2c3e50;
  top: 0%;
  
}
.centered{
  position:absolute;
  top:20%;
  left: 50%;
  transform: translate(-50%,-50%);
  text-align: center;
}
.top{
    font-size: 60px;
    background-color: #a3a7aa;
    
}
.top2{
    font-size: 40px;
    background-color: #a3a7aa;
    
}


</style>
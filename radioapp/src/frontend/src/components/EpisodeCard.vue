<template>




    <div class="episode-card">

        
        <h2>
          {{ ourDate }}
          - 
          {{episode.title}}
          
        </h2>


        

    </div>

</template>



<script>
// theDate = new Date().toLocaleString()
//let thisDate;

//thisDate = new Date().toLocaleString(); // Calling the constructor for the date --> gets current date time
//thisDate = new Date(this.episode.startTimeUtc).toLocaleString();
//console.log(thisDate);

export default {

    props: ["episode"],

    computed: {
      ourDate() {
        return new Date(this.episode.startTimeUtc).toLocaleString();

      }
    }
/*
 episodesByProgramId() {
            return this.$store.getters.getEpisodesOnProgram
       },


*/



}

</script>



<style>



</style>
// Date = new Date(1618231050329).toLocaleString()
<template>
    <div class="episode-card">

        
        <h2>
          {{ ourDate }}
          - 
          {{episode.title}}
          
        </h2>

<!-- Only show buttons if user is logged in -->
  <div v-if="isLoggedIn">
  <button @click="addFavorite(this.episode.episodeid)">Add favorite</button>
  </div>

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
    loggedInUser() {
      return this.$store.state.loggedInUser
    },
    isLoggedIn() {
      return this.loggedInUser != null
    },
    
    //------- User Story 8 -------------

    // Final step: Create a function (ourDate) that will get the the start time from the API and convert it from epoch to UTC
    ourDate() {
        return new Date(this.episode.startTimeUtc).toLocaleString();
},
},

methods: {
    
    async addFavorite(episodeId) {
        //Putting programID in credentials 
            let credentials = {
                episodeId: episodeId,
            }
            //console.log('credentials are: '+ credentials)

            //Sends credentials as json object to backend
        let response = await fetch("/rest/favorites/add-favorite", {
            method: "POST",
            headers: {'Content-Type': 'application/json' },
            body: JSON.stringify(credentials)
      });
          //Debug
        if(response.url.includes('error')) {
            console.log('Error');
        } else {
            console.log(response)
        }
      },
}
}

</script>



<style>
.episode-card {
  background-color: lightgray;
  margin-bottom: 20px;
  padding: 10px;
  font-family: 'Arial';
  border-radius: 30px;
  border: 5px solid whitesmoke;
  width: 100%;
  
  }


</style>

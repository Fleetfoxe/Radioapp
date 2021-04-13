<template>
<div  class="program-card">

  <div @click="redirectToProgramDetails">
    <h2> {{program.name}} </h2>
</div>
  <!-- Only show buttons if user is logged in -->
  <div v-if="isLoggedIn">
  <button @click="addFavorite(this.program.id)">Add favorite</button>
  </div>
</div>
</template>

<script>
export default {
  props: ["program"],

   computed: {
    loggedInUser() {
      return this.$store.state.loggedInUser
    },
    isLoggedIn() {
      return this.loggedInUser != null
    }
  },

  methods: {
    redirectToProgramDetails() {
      let routerUrl = '/program-details/' + this.program.id
      this.$router.push({path: routerUrl})
    },

    async addFavorite(programId) {
            //Putting programID in credentials 
            let credentials = {
                programId: programId,
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
.program-card {
  background-color: lightgray;
  margin-bottom: 20px;
  padding: 10px;
  font-family: 'Arial';
  border-radius: 30px;
  border: 5px solid whitesmoke;
}

</style>
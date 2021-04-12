<template>
  <div class="favorite-card">
      <h3>{{ favoriteId }}</h3>
      <h2>{{ program.name }}</h2>
      <h4>{{ msg }}</h4>
  </div>
</template>

<script>
export default {
    props: ["favorite", "favoriteId", "msg"],

   

    emits: ['get-programName'],
        
    computed: {
    program() {
            //This is step 4. Here we get the program object from store that comes from springboot 
            return this.$store.getters.getProgramById
        },
    },
    mounted() {
        //This is step 2. We take the id from the id int in data() and we send it to ProgramId int in store.js
        // it will be used to fetch the correct program from springboot
        this.$store.commit("setProgramId", this.favoriteId)

        //This is step 3. Here we activate the connection to springboot with action fetchProgramById
        this.$store.dispatch("fetchProgramById");
    }
}
</script>

<style>
.favorite-card {
  background-color: lightgray;
  margin-bottom: 20px;
  padding: 10px;
  font-family: 'Arial';
  border-radius: 30px;
  border: 5px solid whitesmoke;
}
</style>
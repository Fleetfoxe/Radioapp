<template>


<div class="category-card" @click="redirectToCategoryDetails">
    <h2>
     <span>{{ category.name }}</span> 
    </h2>
        
    </div>
</template>

<script>
export default {
    props: ["category"],
    methods: {
        redirectToCategoryDetails() {
            let routerUrl = '/category-details/' + this.category.id
            this.$router.push({path: routerUrl})
        }
    }
    
};
</script>

<style>

.category-card {

  background-color: lightgray;
  margin-bottom: 20px;
  padding: 10px;
  font-family: 'Arial';
  border-radius: 30px;
  border: 5px solid whitesmoke;
}



</style>
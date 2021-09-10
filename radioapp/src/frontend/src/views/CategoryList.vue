<template>
<h1>Categories</h1>

  <div class="category-list">

      <!-- Insert category in categoriesList (Nestlar componenten CategoryCard i CategoryList)  (User story 4)-->
      <!-- Loopar ut (v-for) listan av kategorier enskilt = Skapar varje "category" som en egen komponent (User story 4)-->  
    <div v-if="categories.length > 0">
      <CategoryCard 
        v-for="(category, i) in categories"
        :key="category + i"
        :category="category"

      /> 
    </div>
   </div>
</template>

<script>

// Import Categorycard to use in CategoryList (User story 4)
import CategoryCard from "../components/CategoryCard.vue";

export default {
 
 // declare CategoryCard from import (User story 4)
  components: {
    CategoryCard,
  },

 
  computed: {
  // Hämtar kategorilistan från store (User story 4)
    categories() {
            return this.$store.getters.getCategory
        },
    
  },

  // Aktiverar kopplingen till backend (User story 4)
  mounted() {
        this.$store.dispatch("fetchCategory");
    }
};
</script>

<style>

</style>
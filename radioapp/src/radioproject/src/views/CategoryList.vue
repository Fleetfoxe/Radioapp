<template>
    <div class="category-list">

        <div v-if="categories.length > 0">
            <Category

                v-for="(category, i) in categories"
                :key="i"
                :category="category"
            />
        </div>
    </div>
</template>

<script>
import Category from "../components/Category.vue"
export default {
    name: "categoryListComponent",
    components: {
        Category,
    },

    computed: {
        categories(){
            return this.$store.state.categories;
        },
    },
    
};
</script>
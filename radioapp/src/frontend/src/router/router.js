import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
import ChannelList from "@/views/ChannelList";
import CategoryList from "@/views/CategoryList.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/channellist",
    component: ChannelList
  },
  {
    path: "/categorylist",
    component: CategoryList
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;

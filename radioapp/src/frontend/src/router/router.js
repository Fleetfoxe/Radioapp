import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
import ChannelList from "@/views/ChannelList";
import CategoryList from "@/views/CategoryList";
import ProgramList from "@/views/ProgramList"
import ProgramDetails from "@/views/ProgramDetails.vue"
import ChannelDetails from "@/views/ChannelDetails.vue"
import CategoryDetails from "@/views/CategoryDetails.vue"
import Login from "@/views/Login.vue"



const routes = [
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
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
  {
    path: "/programlist",
    component: ProgramList
  },
  {
    path: "/program-details/:id",
    component: ProgramDetails
  },
  {
    path: "/category-details/:id",
    component: CategoryDetails
  },
  {
    path: "/channel-details/:id",
    component: ChannelDetails
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;

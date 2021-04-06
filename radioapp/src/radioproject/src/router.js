import {createRouter, createWebHistory} from 'vue-router'

import ProgramsInChannel from './views/ProgramsInChannel.vue'
import Home from './views/Homepage.vue'
import ChannelList from './views/ChannelList.vue'
import CategoryList from './views/CategoryList.vue'

// create routes
// match components with an URL

const routes = [ 
    {
    path: '/',
    component: Home
    },
    {
    path: '/programsinchannel',
    component: ProgramsInChannel
    },
    {
    path: '/channellist',
    component: ChannelList
    },
    {
    path: '/categoryList',
    component: CategoryList
    }
]

export default createRouter({
    routes,
    history: createWebHistory()
})

import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import PaymentManager from "./components/listers/PaymentCards"
import PaymentDetail from "./components/listers/PaymentDetail"

import InformMgmtManager from "./components/listers/InformMgmtCards"
import InformMgmtDetail from "./components/listers/InformMgmtDetail"

import OrderMgmtManager from "./components/listers/OrderMgmtCards"
import OrderMgmtDetail from "./components/listers/OrderMgmtDetail"
import CookManager from "./components/listers/CookCards"
import CookDetail from "./components/listers/CookDetail"

import DeliveryMgmtManager from "./components/listers/DeliveryMgmtCards"
import DeliveryMgmtDetail from "./components/listers/DeliveryMgmtDetail"



export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/payments',
                name: 'PaymentManager',
                component: PaymentManager
            },
            {
                path: '/payments/:id',
                name: 'PaymentDetail',
                component: PaymentDetail
            },

            {
                path: '/informMgmts',
                name: 'InformMgmtManager',
                component: InformMgmtManager
            },
            {
                path: '/informMgmts/:id',
                name: 'InformMgmtDetail',
                component: InformMgmtDetail
            },

            {
                path: '/orderMgmts',
                name: 'OrderMgmtManager',
                component: OrderMgmtManager
            },
            {
                path: '/orderMgmts/:id',
                name: 'OrderMgmtDetail',
                component: OrderMgmtDetail
            },
            {
                path: '/cooks',
                name: 'CookManager',
                component: CookManager
            },
            {
                path: '/cooks/:id',
                name: 'CookDetail',
                component: CookDetail
            },

            {
                path: '/deliveryMgmts',
                name: 'DeliveryMgmtManager',
                component: DeliveryMgmtManager
            },
            {
                path: '/deliveryMgmts/:id',
                name: 'DeliveryMgmtDetail',
                component: DeliveryMgmtDetail
            },




    ]
})

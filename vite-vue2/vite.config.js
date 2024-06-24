import { createVuePlugin } from 'vite-plugin-vue2'
import inspect from 'vite-plugin-inspect'

export default {
    plugins: [createVuePlugin(),inspect()]
}

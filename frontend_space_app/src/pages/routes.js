import Bitacora from '../pages/Bitacora/index'
import AddBitacora from '../pages/Bitacora/add-bitacora'

const routes = [
    {
        path: '/',
        name: 'Consola',
        icon: <i class="fas fa-file-alt"></i>,
        component: Bitacora,
        exact: true
    },
    {
        path: '/add-registro',
        name: 'Agregar Registro',
        icon: <i class="fas fa-plus"></i>,
        component:  AddBitacora,
        exact: false

    
    }
    
];
export default routes;

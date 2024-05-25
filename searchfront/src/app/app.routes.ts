import { Routes } from '@angular/router';

import { SearchViewComponent } from './search-view/search-view.component'
import { DetailViewComponent } from './detail-view/detail-view.component';

export const routes: Routes = [
    {
        path: '',
        component: SearchViewComponent
    },
    {
        path: 'detail-view',
        component: DetailViewComponent
    }
];

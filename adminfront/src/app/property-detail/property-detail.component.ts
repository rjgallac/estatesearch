import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-property-detail',
  standalone: true,
  imports: [],
  templateUrl: './property-detail.component.html',
  styleUrl: './property-detail.component.css'
})
export class PropertyDetailComponent {

  fileName = '';
  constructor(private http: HttpClient) {}


  onFileSelected(event: any) {
    const file:File = event.target.files[0];
    if (file) {
        this.fileName = file.name;
        const formData = new FormData();
        formData.append("file", file);
        const upload$ = this.http.post("http://127.0.0.1:8084/imageupload/" + 1, formData);
        upload$.subscribe();
    }
}

}

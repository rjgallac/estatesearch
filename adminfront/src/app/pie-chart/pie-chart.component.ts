import { Component } from '@angular/core';
import Chart from 'chart.js/auto'

@Component({
  selector: 'app-pie-chart',
  standalone: true,
  imports: [],
  templateUrl: './pie-chart.component.html',
  styleUrl: './pie-chart.component.css'
})
export class PieChartComponent {

  public chart: any;


  ngOnInit(): void {
    this.createChart();
  }



  createChart(){
  
    this.chart = new Chart("MyPieChart", {
      type: 'pie', //this denotes tha type of chart

      data : {
        labels: [
          'Red',
          'Blue',
          'Yellow'
        ],
        datasets: [{
          label: 'My First Dataset',
          data: [300, 50, 100],
          backgroundColor: [
            'rgb(255, 99, 132)',
            'rgb(54, 162, 235)',
            'rgb(255, 205, 86)'
          ],
          hoverOffset: 4
        }]
      },
      options: {
        aspectRatio:1.5
      }
      
    });
  }

}

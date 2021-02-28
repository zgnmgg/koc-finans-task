import {Component, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Income} from "../model/income.model";
import {IncomeService} from "../service/income.service";
import {ScoreService} from "../service/score.service";
import {CityModel} from "../model/city.model";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  // @ts-ignore
  @ViewChild('postForm') slForm: NgForm;
  isLoading = false;
  incomes: Income = null;
  error = null;
  score = null;
  cityModel: CityModel[] = [
    { name: 'Adana', code: 'i01' },
    { name: 'Antalya', code: 'i07' },
    { name: 'İstanbul', code: 'i34' },
    { name: 'Ankara', code: 'i06' },
    { name: 'İzmir', code: 'i35' },
    { name: 'Bursa', code: 'i16' },
    { name: 'Kahramanmaraş', code: 'i46' },
    { name: 'Sinop', code: 'i57' },
    { name: 'Ordu', code: 'i52' },
  ];

  constructor(
    private http: HttpClient,
    private incomeService: IncomeService,
    private scoreService: ScoreService
  ) {
  }

  ngOnInit() {
     this.incomeService.getAllIncomes().subscribe(
       resData => {
            this.incomes = resData;
          },
     );
  }

  onCreatePost(postData: { identityNumber: string; name: string, surname: string, phone: string, income: string, city: string }) {
    this.score = null;
    this.scoreService.addUser(postData).subscribe(
      resData => {
        this.score = resData.score;
        this.isLoading = false;
      },
      errorMessage => {
        this.error = errorMessage;
        this.isLoading = false;
      }
    );

    this.slForm.reset();
  }
}

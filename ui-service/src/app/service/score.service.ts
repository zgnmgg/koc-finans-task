import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

interface ResponseData {
  identityNumber: string;
  phone: string;
  name: string;
  surname: string;
  city: string;
  score: bigint;
}

interface RequestData {
  identityNumber: string,
  name: string,
  surname: string,
  phone: string,
  income: string,
  city: string
}

@Injectable({ providedIn: 'root' })
export class ScoreService {
  constructor(private http: HttpClient) {}

  getUserScore(identityNumber: string) {
    return this.http
      .get<ResponseData>(
        'http://localhost:8081/api/score/' + identityNumber,
        {
        }
      )
      .pipe(
        catchError(errorRes => {
          let errorMessage = 'An unknown error occurred!';
          if (errorRes.error.message) {
            errorMessage = errorRes.error.message
          }
          return throwError(errorMessage);
        })
      );
  }

  addUser(data: RequestData) {
    return this.http
      .post<ResponseData>(
        'http://localhost:8081/api/add-user',
        {
          identityNumber: data.identityNumber,
          name: data.name,
          surname: data.surname,
          phone: data.phone,
          income: data.income,
          city: data.city
        }
      )
      .pipe(
        catchError(errorRes => {
          let errorMessage = 'An unknown error occurred!';
          if (errorRes.error.message) {
            errorMessage = errorRes.error.message
          }
          return throwError(errorMessage);
        })
      );
  }
}

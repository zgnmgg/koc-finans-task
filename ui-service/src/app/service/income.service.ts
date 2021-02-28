import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {catchError} from "rxjs/operators";
import {throwError} from "rxjs";

interface Income {
  code: bigint;
  multipler: bigint;
  description: string;
}

@Injectable({ providedIn: 'root' })
export class IncomeService {
  constructor(private http: HttpClient) {}

  getAllIncomes() {
    return this.http
      .get<Income>(
        'http://localhost:8081/api/income/all',
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
}

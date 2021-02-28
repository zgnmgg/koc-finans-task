import {Component, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {ScoreService} from "../service/score.service";

@Component({
  selector: 'app-score',
  templateUrl: './score.component.html',
  styleUrls: ['./score.component.css']
})
export class ScoreComponent  {
  isLoading = false;
  error: string = null;
  score = null;
  // @ts-ignore
  @ViewChild('postForm') slForm: NgForm;

  constructor(private scoreService: ScoreService) { }

  onSubmit(postData: {identityNumber: string}) {
    this.error = null;
    this.score = null;
    const identityNumber = postData.identityNumber;
    this.isLoading = true;

    this.scoreService.getUserScore(identityNumber).subscribe(
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

import { isNgTemplate } from '@angular/compiler';
import { Pipe, PipeTransform } from '@angular/core';
import { EventData } from '../common/event';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(value: any[], filterString: string, eventName: string): any [] {
    console.log(filterString,eventName);
    const resultArray = [];
    if (value){
    if (value.length === 0 || filterString === '' || eventName === '') {
      console.log("returning everything");
      return value;
    }

    for (const item of value) {
     
      if ((String)(item[eventName]).toLocaleLowerCase().includes(filterString.toLocaleLowerCase())) {
        resultArray.push(item);
      }
   
    }
  }
  console.log(resultArray);
    return resultArray;
  

}
}

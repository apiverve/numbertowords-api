declare module '@apiverve/numbertowords' {
  export interface numbertowordsOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface numbertowordsResponse {
    status: string;
    error: string | null;
    data: NumbertoWordsData;
    code?: number;
  }


  interface NumbertoWordsData {
      number:                number;
      words:                 string;
      ordinal:               string;
      numberOfDigitsNumeric: number;
      numberOfDigitsWords:   string;
      eachNumber:            string[];
      afterDecimal:          AfterDecimal;
      locale:                string;
  }
  
  interface AfterDecimal {
      number:                string;
      words:                 string[];
      numberOfDigitsNumeric: number;
      numberOfDigitsWords:   string;
  }

  export default class numbertowordsWrapper {
    constructor(options: numbertowordsOptions);

    execute(callback: (error: any, data: numbertowordsResponse | null) => void): Promise<numbertowordsResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: numbertowordsResponse | null) => void): Promise<numbertowordsResponse>;
    execute(query?: Record<string, any>): Promise<numbertowordsResponse>;
  }
}

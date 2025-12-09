using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.NumbertoWords
{
    /// <summary>
    /// Query options for the Number to Words API
    /// </summary>
    public class NumbertoWordsQueryOptions
    {
        /// <summary>
        /// The number to convert to words
        /// Example: 975.07
        /// </summary>
        [JsonProperty("number")]
        public string Number { get; set; }
    }
}

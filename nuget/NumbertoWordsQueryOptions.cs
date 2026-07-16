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
        /// </summary>
        [JsonProperty("number")]
        public double Number { get; set; }
    }
}

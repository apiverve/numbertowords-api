# Number to Words API - Ruby Gem

Number to Words is a number to words API that converts numeric values into written cardinal words and counts whole and fractional digits. Pass any integer or float to get the spelled-out text along with digit counts and locale information.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_numbertowords'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_numbertowords
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_numbertowords'

# Initialize the client
client = APIVerve::Numbertowords::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({ number: 975.07 })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ number: 975.07 })
  puts response["data"]
rescue APIVerve::Numbertowords::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Numbertowords::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Numbertowords::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "number": 975.07,
    "words": "nine hundred seventy-five point zero seven",
    "ordinal": "nine hundred seventy-fifth point zero seven",
    "numberOfDigits_numeric": 3,
    "numberOfDigits_words": "three",
    "eachNumber": [
      "nine",
      "seven",
      "five"
    ],
    "afterDecimal": {
      "number": "07",
      "words": [
        "zero",
        "seven"
      ],
      "numberOfDigits_numeric": 2,
      "numberOfDigits_words": "two"
    },
    "locale": "en-US"
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/numbertowords?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/numbertowords?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/numbertowords?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).

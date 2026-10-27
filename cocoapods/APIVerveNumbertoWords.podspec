Pod::Spec.new do |s|
  s.name             = 'APIVerveNumbertoWords'
  s.version          = '1.2.3'
  s.summary          = 'Number to Words is a number to words API that converts numeric values into written cardinal words and counts whole and fractional digits.'
  s.description      = <<-'DESC'
Number to Words is a number to words API that converts numeric values into written cardinal words and counts whole and fractional digits. Pass any integer or float to get the spelled-out text along with digit counts and locale information.

This iOS/macOS SDK provides a convenient way to access the Number to Words from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/numbertowords?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/numbertowords-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveNumbertoWords/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end


Pod::Spec.new do |s|
  s.name         = "RNPopdeem"
  s.version      = "1.0.0"
  s.summary      = "RNPopdeem"
  s.description  = <<-DESC
                  RNPopdeem
                   DESC
  s.homepage     = ""
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/author/RNPopdeem.git", :tag => "master" }
  s.source_files  = "RNPopdeem/**/*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  s.dependency "PopdeemSDK"
  #s.dependency "others"

end

  